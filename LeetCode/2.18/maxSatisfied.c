int maxSatisfied(int* customers, int customersSize, int* grumpy, int grumpySize, int minutes) {
    int total=0;int num=0;
    for(int i=0;i<minutes;i++){
        if(!grumpy[i])total+=customers[i];
        if(grumpy[i])num+=customers[i];
    }

    int max=num;
    for(int i=0;i<customersSize-minutes;i++){
        if(grumpy[i])num-=customers[i];
        if(grumpy[i+minutes])num+=customers[i+minutes];
        if(!grumpy[i+minutes])total+=customers[i+minutes];
        max=max>num?max:num;
        
    }
    return total+max;




}