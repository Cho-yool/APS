class Num{
    constructor(num){
        this.num = num;
    }
    
    getDifferentBit(){
        if(this.num % 2 == 0)return this.num+1;
        let current = "0" + this.num.toString(2);
        let totalLength = current.length;
        for (let j = totalLength - 1; j >= 0; j--) {
            if (+current[j] === 0) {
                return(
                parseInt(
                    current.substring(0, j) +
                    "10" +
                    current.substring(j + 2, totalLength),
                2));
            }
        }
    }
}

function solution(numbers) {
    var answer = [];
    numbers.forEach((n)=>{
        const num = new Num(n);
    
        answer.push(num.getDifferentBit());
    })
    return answer;
}