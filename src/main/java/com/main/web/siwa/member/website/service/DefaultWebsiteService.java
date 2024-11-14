package com.main.web.siwa.member.website.service;

import com.main.web.siwa.entity.Website;
import com.main.web.siwa.entity.WebsiteImage;
import com.main.web.siwa.ghost.websiteImage.dto.WebsiteImageListDto;
import com.main.web.siwa.member.website.dto.WebsiteCreateDto;
import com.main.web.siwa.member.website.dto.WebsiteListDto;
import com.main.web.siwa.member.website.dto.WebsiteResponseDto;
import com.main.web.siwa.member.website.dto.WebsiteSearchDto;
import com.main.web.siwa.repository.WebsiteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.IntStream;

@Service("memberWebsiteService")
public class DefaultWebsiteService implements WebsiteService {

    private WebsiteRepository websiteRepository;
    private ModelMapper modelMapper;

    public DefaultWebsiteService(WebsiteRepository websiteRepository
            , ModelMapper modelMapper){
        this.websiteRepository = websiteRepository;
        this.modelMapper = modelMapper;
    }


    // 전달 받은 데이터를
    @Override
    public WebsiteResponseDto getList(WebsiteSearchDto websiteSearchDto) {
        return getList(websiteSearchDto.getPage(), websiteSearchDto.getKeyWord(), websiteSearchDto.getCategoryId());
    }
    
    // 여기서 꺼내 쓰기
    @Override
    public WebsiteResponseDto getList(Integer page, String keyWord, Long categoryId) {
        Sort sort = Sort.by("regDate").descending();
        Pageable pageable = PageRequest.of(page-1, 30, sort); // 0
        Page<Website> websitePage = websiteRepository.findAll(keyWord, categoryId, page, 30);

        // Entity를 DTO로 바꾸기 > Stream
        List<WebsiteListDto> websiteListDtos = websitePage
                .getContent()
                .stream()
                .map((Website website) -> {
                    WebsiteListDto websiteListDto = modelMapper.map(website, WebsiteListDto.class);

                    // 이미지
                    List<WebsiteImageListDto> imageListDtos =
                            website
                                    .getImages()
                                    .stream()
                                    .map((WebsiteImage image) -> modelMapper.map(image, WebsiteImageListDto.class))
                                    .toList();
                    websiteListDto.setImages(imageListDtos);

                    return websiteListDto;
                })
                .toList();

        // 조회된 모든 웹사이트 갯수
        long websiteTotalCount = websitePage.getTotalElements();
        long websiteTotalPages = websitePage.getTotalPages();
        boolean nextPage = websitePage.hasNext();
        boolean previousPage = websitePage.hasPrevious();

        // 현재 페이지
        page = (page == null) ? 1 : page;

        // 페이지 구간
        Integer offset = (page -1) % 5;

        // 현재 페이지에서 다른 페이지 구하기
        Integer startNum = page - offset;
        List<Integer> pages = IntStream
                .range(startNum, startNum+5)
                .boxed().toList();


        return WebsiteResponseDto
                .builder()
                .websiteListDtos(websiteListDtos)
                .websiteTotalCount(websiteTotalCount)
                .websiteTotalPages(websiteTotalPages)
                .nextPage(nextPage)
                .prevPage(previousPage)
                .pages(pages)
                .build();
    }

    // GET + id
    @Override
    public WebsiteListDto getById(Long id) {
       Website website =  websiteRepository
               .findById(id)
               .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 웹사이트입니다. id = " + id));
        return modelMapper.map(website, WebsiteListDto.class);
    }
    // POST
    @Override
    @Transactional
    public WebsiteCreateDto create(WebsiteCreateDto websiteCreateDto,
                                   List<MultipartFile> images) {
        // 중복검사
//        Website website = websiteRepository.findById(websiteDto.getId()).orElseThrow();
//        if(websiteDto.getUrl().equals(website));

        Website website = websiteRepository.save(modelMapper.map(websiteCreateDto, Website.class));
        return modelMapper.map(website, WebsiteCreateDto.class);
    }
    // PUT
    @Override
    public WebsiteListDto update(WebsiteListDto websiteListDto) {
        // 1. JPA SQL Method
        // 업데이트는 기존에 존재하는 테이블에만 데이터를 저장할 수 있게
        // 테이블 id가 있는지 확인하는 과정을 넣는다.
        Website website = websiteRepository
                .findById(websiteListDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 웹사이트입니다. id = " + websiteListDto.getId()));

        // 일괄 업데이트가 아닌 부분 업데이트 로직을 구현함
        if(websiteListDto.getTitle() != null)
            website.setTitle(websiteListDto.getTitle());
//        if(websiteListDto.getWebsiteImages() != null)
//            website.setImages(websiteListDto.getImages());
//        if(websiteListDto.getCategory() != null)
//            website.setCategory(websiteListDto.getCategory());

        // JPA가 알아서 save()하긴 하는데
        websiteRepository.save(website);

        // 혹시 모르니까 저장 후에도 id 확인
        Website updateWebsite = websiteRepository
                .findById(websiteListDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 웹사이트입니다. id = " + websiteListDto.getId()));

        return modelMapper.map(updateWebsite, WebsiteListDto.class);

    }
    // DELETE
    @Override
    public void delete(Long id) {
        websiteRepository.deleteById(id);
    }

}
