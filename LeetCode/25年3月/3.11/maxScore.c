int maxScore(int* cardPoints, int cardPointsSize, int k) {
    if(k==cardPointsSize){
        int sum=0;
        for(int i=0;i<cardPointsSize;i++){
            sum+=cardPoints[i];
        }
        return sum;
    }else{
        int sum=0;
        for(int i=0;i<k;i++){
            sum+=cardPoints[i];
        }
        int temp=sum;
        for(int i=k-1;i>=0;i--){
            temp=temp-cardPoints[i]+cardPoints[cardPointsSize-(k-i)];
            sum=sum>temp?sum:temp;
        }
        return sum;
    }
}