package com.main.web.siwa.member.website.service;

import com.main.web.siwa.member.website.util.FileUpload;
import com.main.web.siwa.entity.*;
import com.main.web.siwa.ghost.websiteImage.dto.WebsiteImageListDto;
import com.main.web.siwa.member.website.dto.*;
import com.main.web.siwa.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service("memberWebsiteService")
public class DefaultWebsiteService implements WebsiteService {

    private final WebsiteRepository websiteRepository;
    private final MemberRepository memberRepository;
    private final WebsiteImageRepository websiteImageRepository;
    private final LikeRepository likeRepository;
    private final DislikeRepository dislikeRepository;
    private final BookmarkRepository bookmarkRepository;
    private final ModelMapper modelMapper;

    public DefaultWebsiteService(
            WebsiteRepository websiteRepository,
            MemberRepository memberRepository,
            WebsiteImageRepository websiteImageRepository,
            LikeRepository likeRepository,
            DislikeRepository dislikeRepository,
            BookmarkRepository bookmarkRepository,
            ModelMapper modelMapper){
        this.websiteRepository = websiteRepository;
        this.memberRepository = memberRepository;
        this.websiteImageRepository = websiteImageRepository;
        this.likeRepository = likeRepository;
        this.dislikeRepository = dislikeRepository;
        this.bookmarkRepository = bookmarkRepository;
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
        System.out.println(categoryId);
        System.out.println(keyWord);
        System.out.println(page);

        int size = 30; // 페이지당 보여줄 웹사이트 개수
        if (page == null || page < 1) {
            page = 1;
        }
        Sort sort = Sort.by("regDate").descending();
        Pageable pageable = PageRequest.of(page-1, size, sort); // 0
        Page<Website> websitePage = websiteRepository.findAll(keyWord, categoryId, page, size);

        // Entity를 DTO로 바꾸기 > Stream
        List<WebsiteListDto> websiteListDtos = websitePage
                .getContent()
                .stream()
                .map((Website website) -> {
                    WebsiteListDto websiteListDto = modelMapper.map(website, WebsiteListDto.class);

                    // 이미지
                    // 이미지, null이 아닐 경우에만 매핑
                    List<WebsiteImageListDto> imageListDtos =
                            website.getImages() != null ?
                                    website.getImages()
                                            .stream()
                                            .map((WebsiteImage image) -> modelMapper.map(image, WebsiteImageListDto.class))
                                            .toList() : new ArrayList<>();
                    websiteListDto.setImages(imageListDtos);

                    return websiteListDto;
                })
                .toList();

        // 조회된 모든 웹사이트 갯수
        long totalCount = websitePage.getTotalElements();
        long totalPages = websitePage.getTotalPages();
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
                .totalCount(totalCount)
                .totalPages(totalPages)
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
    public WebsiteCreateDto create(WebsiteCreateDto websiteCreateDto, MultipartFile image) {

        Website createdWebsite = websiteRepository.save(modelMapper.map(websiteCreateDto, Website.class));

        // 이미지 파일 경로에 저장
        if (image != null && !image.isEmpty()) {
            FileUpload fileUpload = new FileUpload();
            String savedImagePath = fileUpload.saveImage(image, "rawdotweb/images/website");
            System.out.println("savedImagePath: " + savedImagePath);
            
            // 경로 제외 파일명만
//            String fileName = savedImagePath.substring(savedImagePath.lastIndexOf(File.separator) + 1); // 파일명 추출
            String fileName = Paths.get(savedImagePath).getFileName().toString();
            System.out.println("Extracted File Name: " + fileName);
            // 3. WebsiteImage 엔티티 생성 및 저장

            WebsiteImage websiteImage = WebsiteImage.builder()
                    .src(fileName)
                    .isDefault(true) // 첫 번째 이미지는 기본 이미지로 설정
                    .website(createdWebsite) // 연관 관계 설정
                    .build();

            websiteImageRepository.save(websiteImage); // 저장
        }

        return modelMapper.map(createdWebsite, WebsiteCreateDto.class);
    }
    // PUT
    @Override
    public WebsiteListDto update(WebsiteListDto websiteListDto, MultipartFile newImage) {
        // 1. JPA SQL Method
        // 업데이트는 기존에 존재하는 테이블에만 데이터를 저장할 수 있게
        // 테이블 id가 있는지 확인하는 과정을 넣는다.
        Website website = websiteRepository
                .findById(websiteListDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 웹사이트입니다. id = " + websiteListDto.getId()));

        // 일괄 업데이트가 아닌 부분 업데이트 코드
        if(websiteListDto.getTitle() != null)
            website.setTitle(websiteListDto.getTitle());

        if(websiteListDto.getUrl() != null)
            website.setUrl(websiteListDto.getUrl());

        if(websiteListDto.getCategory() != null)
            website.setCategory(modelMapper.map(websiteListDto.getCategory(), Category.class));
        
        // 이미지 업데이트
        if (newImage != null && !newImage.isEmpty()) {
            FileUpload fileUpload = new FileUpload();
            String savedImagePath = fileUpload.saveImage(newImage, "rawdotweb/images");

            // WebsiteImage 엔티티 생성 및 저장
            WebsiteImage newWebsiteImage = WebsiteImage.builder()
                    .src(savedImagePath)
                    .isDefault(true) // 새 이미지는 기본 이미지가 아닐 수 있음
                    .website(website) // 연관 관계 설정
                    .build();

            websiteImageRepository.save(newWebsiteImage);
        }
        // 저장
        Website updatedWebsite = websiteRepository.save(website);
        // 업데이트 된 웹사이트 가져오기
//        Website updateWebsite = websiteRepository
//                .findById(websiteListDto.getId())
//                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 웹사이트입니다. id = " + websiteListDto.getId()));
        return modelMapper.map(updatedWebsite, WebsiteListDto.class);

    }
    // DELETE
    @Override
    public void delete(Long id) {
        websiteRepository.deleteById(id);
    }

    @Override
    public void interaction(InteractionDto interactionDto) {
        String action = interactionDto.getAction();

        // 해당 Entity의 속성(필드)가 사용도기 전까지 실제 쿼리가 실행되지 않음(프록시)
        Member member = memberRepository.getReferenceById(interactionDto.getMemberId());
//                .orElseThrow(() -> new IllegalArgumentException("Invalid member ID: " + interactionDto.getMemberId()));
        Website website = websiteRepository.getReferenceById(interactionDto.getWebsiteId());
//                .orElseThrow(() -> new IllegalArgumentException("Invalid website ID: " + interactionDto.getWebsiteId()));

        // 클라이언트에서 보내는 값과 일치하는 것을 찾기
        switch (action.toLowerCase()) {
            case "like":
                if(likeRepository.existsByWebsiteAndMember(member, website)) {
                    Likes existingLike = likeRepository.findByWebsiteAndMember(website, member)
                            .orElseThrow(() -> new IllegalArgumentException("좋아요"));
                    likeRepository.delete(existingLike);
                } else {
                    Likes likes = new Likes();
                    likes.setMember(member);
                    likes.setWebsite(website);
                    likeRepository.save(likes);
                }
                break;
            case "dislike":
                if(dislikeRepository.existsByWebsiteAndMember(member, website)) {
                    Dislike existingDislike = dislikeRepository.findByWebsiteAndMember(website, member)
                            .orElseThrow(() -> new IllegalArgumentException("의견이 전달되었습니다."));
                    dislikeRepository.delete(existingDislike);
                }
                Dislike dislikes = new Dislike();
                dislikes.setMember(member);
                dislikes.setWebsite(website);
                dislikeRepository.save(dislikes);
                break;
            case "bookmark":
                if(bookmarkRepository.existsByWebsiteAndMember(member, website)) {
                    Bookmark existingBookmark = bookmarkRepository.findByWebsiteAndMember(website, member)
                            .orElseThrow(() -> new IllegalArgumentException("저장되었습니다."));
                    bookmarkRepository.delete(existingBookmark);
                }
                Bookmark bookmark = new Bookmark();
                bookmark.setMember(member);
                bookmark.setWebsite(website);
                bookmarkRepository.save(bookmark);
                break;

            default:
                throw new IllegalArgumentException("잘못된 요청입니다.");
        }
    }

}
