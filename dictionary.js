// 문서객체선택
var dicBtn = document.querySelectorAll('.dicBox dt a');

for(var i=0; i<dicBtn.length; i++){
	dicBtn[i].addEventListener('click', function(){
    	event.preventDefault();
    	
        for(var j=0; j<dicBtn.length; j++){
            if(dicBtn[j] != this){
            	dicBtn[j].parentNode.classList.remove('active');
            }
        }
        
        this.parentNode.classList.toggle('active');
    });
}