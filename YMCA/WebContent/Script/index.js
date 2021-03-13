

//カウントダウンタイマー
var countdown = function(due){
    var now = new Date();
    
    var rest = due.getTime() - now.getTime();
    var seconds = Math.floor(rest/1000) % 60 ;
    var min = Math.floor(rest/1000/60)% 60;
    
    var hours = Math.floor(rest/1000/60/60) % 24;
    var days = Math.floor(rest/1000/60/60/24);
    
    var count = [days,hours,min,seconds];
    
    return count;
    
}

var goal = new Date();
goal.setHours(23);
goal.setMinutes(59);
goal.setMilliseconds(59);

var counter = countdown(goal);
var time = counter[1] + "時間" + counter[2] + "分" + counter[3] + "秒" ;

console.log(time);

document.getElementById("timer").textContent = time;
