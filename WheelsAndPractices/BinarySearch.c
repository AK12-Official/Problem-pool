int BinarySearch(int *Arr,int left,int right,int key){

    while(left<=right){
        // int mid=(left+right)/2;
        // 防止整数溢出，改用这种方式计算 mid
        int mid = left + (right - left) / 2;

        if(Arr[mid]==key){
            return mid;
        }else if(Arr[mid]>key){
            right=mid-1;
        }else{
            left=mid+1;
        }
    }
    return -1;//未找到返回-1
}