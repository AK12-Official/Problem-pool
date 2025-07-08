int numOfSubarrays(int* arr, int arrSize, int k, int threshold) {
    int count=0;

    int sum=0;
    for(int i=0;i<k;i++){
        sum+=arr[i];
    }
    if(sum>=k*threshold)count++;

    for(int i=0;i<arrSize-k;i++){
        sum=sum-arr[i]+arr[i+k];
        if(sum>=k*threshold)count++;
    }
    return count;
}