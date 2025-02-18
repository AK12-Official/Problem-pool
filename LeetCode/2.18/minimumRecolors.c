int minimumRecolors(char* blocks, int k) {
    int len=strlen(blocks);
    
    int num=0;
    for(int i=0;i<k;i++){
        if(blocks[i]='B')
        num++;
    }

    int max=num;
    for(int i=0;i<len-k;i++){
        if(blocks[i]=='B')num--;
        if(blocks[i+k]=='B')num++;
        max=max>num?max:num;
    }
    if(max>=k) return 0;
    return k-max;

}