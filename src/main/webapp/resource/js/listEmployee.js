function showPopup() {
    document.querySelector('.popup').classList.add('active');
    document.querySelector('.popup-overlay').classList.add('active');
}

function closePopup() {
    document.querySelector('.popup').classList.remove('active');
    document.querySelector('.popup-overlay').classList.remove('active');
}

function resetEmpID(){
    document.getElementById('empID').value = '';
}