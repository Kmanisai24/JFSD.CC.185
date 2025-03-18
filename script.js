function updateClock() {
    let now = new Date();
    let hours = now.getHours().toString().padStart(2, '0');
    let minutes = now.getMinutes().toString().padStart(2, '0');
    let seconds = now.getSeconds().toString().padStart(2, '0');
    document.getElementById('clock').innerText = `${hours}:${minutes}:${seconds}`;
}
setInterval(updateClock, 1000);
updateClock();

let alarmTime = null;
let alarmTriggered = false;
const alarmSound = document.getElementById('alarmSound');

document.getElementById('setAlarmBtn').addEventListener('click', function() {
    alarmTime = document.getElementById('alarmTime').value;
    if (alarmTime) {
        document.getElementById('alarmStatus').innerText = `Alarm set for ${alarmTime}`;
    } else {
        alert("Please select a valid time.");
    }
});

document.getElementById('stopAlarmBtn').addEventListener('click', function() {
    alarmSound.pause();
    alarmSound.currentTime = 0;
    document.getElementById('alarmStatus').innerText = "Alarm stopped.";
    alarmTriggered = false;
});

setInterval(() => {
    let now = new Date();
    let currentTime = `${now.getHours().toString().padStart(2, '0')}:${now.getMinutes().toString().padStart(2, '0')}`;
    
    if (alarmTime === currentTime && !alarmTriggered) {
        alarmSound.play();
        document.getElementById('alarmStatus').innerText = "⏰ Alarm Ringing! Click Stop to Stop!";
        alarmTriggered = true;
    }
}, 1000);
