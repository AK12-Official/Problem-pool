// 给你一个非负整数 num ，请你返回将它变成 0 所需要的步数。 如果当前数字是偶数，你需要把它除以 2 ；否则，减去 1 。

int numberOfSteps(int num)
{
    int count = 0;
    for (num; num > 0;)
    {
        if (num % 2 == 0)
        {
            num /= 2;
            count -= -1;
        }
        else
        {
            num--;
            count -= -1;
        }
    }
    return count;
}

//没什么好说的