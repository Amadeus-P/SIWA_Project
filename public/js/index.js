export const slide = () =>{
    document.querySelector('.slide-btn-1').addEventListener('click', function() {
        document.querySelector('.slide-box').style.transform = 'translateX(0vw)';
    });

    document.querySelector('.slide-btn-2').addEventListener('click', function() {
        document.querySelector('.slide-box').style.transform = 'translateX(-100vw)';
    });

    document.querySelector('.slide-btn-3').addEventListener('click', function() {
        document.querySelector('.slide-box').style.transform = 'translateX(-200vw)';
    });
}