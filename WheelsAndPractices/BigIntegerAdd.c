char* BigIntegerAdd(char* A,char * B){
    // 当前函数返回的是动态分配的内存，调用者需要手动释放。如果改为由调用者提供结果缓冲区，可以避免动态分配内存的开销。
    //但是我感觉这么做不太好，因为调用者需要提供足够大的缓冲区，否则会导致缓冲区溢出。
    //就要求调用者需要自行确认传入参数正确 故不做调整
    int lenA = strlen(A);
    int lenB = strlen(B);
    
    int len =lenA>lenB?lenA:lenB;

    char *result = (char*)malloc(sizeof(char)*(len+2));
    result[len+1] = '\0';

    int carry=0;
    int i=lenA-1;
    int j=lenB-1;
    int k=len;

    while(i>=0&&j>=0){
        int sum=A[i]-'0'+B[j]-'0'+carry;
        result[k]=sum%10+'0';
        carry=sum/10;
        i--;
        j--;
        k--;
    }
    while(i>=0){
        int sum=A[i]-'0'+carry;
        result[k]=sum%10+'0';
        carry=sum/10;
        i--;
        k--;
    }
    while(j>=0){
        int sum=B[j]-'0'+carry;
        result[k]=sum%10+'0';
        carry=sum/10;
        j--;
        k--;
    }
    //处理进位
    //为什么这么改进：当前代码在返回结果时，如果返回的是 result+1，会导致原始的 result 指针丢失，无法释放分配的内存。这可能会引发内存泄漏问题。
    if (carry) {
        result[k] = carry + '0';
    } else {
        memmove(result, result + 1, len + 1); // 将结果向前移动
    }
    return result;
}