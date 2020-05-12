ClassicEditor 
    .create( document.querySelector( '#content' ) ) 
    .then( editor => { 
        console.log( editor ); 
    } ) 
    .catch( error => { 
        console.error( error ); 
    } );

const saveBtn = document.getElementById('saveBtn');
saveBtn.addEventListener('click', function(e) {
	e.preventDefault();
	alert('클릭됨');
});
window.onload = CKEDITOR.replace("content", {

});

