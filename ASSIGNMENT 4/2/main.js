const displayedImage = document.querySelector('.displayed-img');
const thumbBar = document.querySelector('.thumb-bar');

const btn = document.querySelector('button');
const overlay = document.querySelector('.overlay');

/* Declaring the array of image filenames */
const imageArray = ['pic1.jpg', 'pic2.jpg','pic3.jpg','pic4.jpg','pic5.jpg'];

/* Declaring the alternative text for each image file */
const altText =['A beautiful Lanscapee','A beautiful Lanscapee','A beautiful Lanscapee','A beautiful Lanscapee','A beautiful Lanscapee'];

/* Looping through images */
for (let i = 0; i <imageArray.length; i++) {
   const newImage = document.createElement('img'); 
   newImage.setAttribute('src', 'images/' + imageArray[i]);
   newImage.setAttribute('alt', altText [i]);
   thumbBar.appendChild(newImage); 

    newImage.addEventListener('click', (e) => {
        displayedImage.src = e.target.src;
    }
    ); 

}

/* Wiring up the Darken/Lighten button */
btn.addEventListener('click', () => {
    const btnClass = btn.getAttribute('class');
    if (btnClass === 'dark') {
        overlay.style.backgroundColor = 'rgba(0, 0, 0, 0.5)'; // Darken the overlay
        btn.setAttribute('class', 'light'); // Update button class
        btn.textContent = 'Lighten'; // Update button text
    } else if (btnClass === 'light') {
        overlay.style.backgroundColor = 'rgba(0, 0, 0, 0)'; // Lighten the overlay
        btn.setAttribute('class', 'dark'); // Update button class
        btn.textContent = 'Darken'; // Update button text
    }
});
