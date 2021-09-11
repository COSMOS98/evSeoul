// 문서객체선택
var faqBtn = document.querySelectorAll('.faqBox dt a');

for(var i=0; i<faqBtn.length; i++){
    faqBtn[i].addEventListener('click', function(event){
    	event.preventDefault();;
    	
        for(var j=0; j<faqBtn.length; j++){
            if(faqBtn[j] != this){
                faqBtn[j].parentNode.classList.remove('active');
            }
        }
        
        this.parentNode.classList.toggle('active');
    });
}