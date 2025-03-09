#include <stdio.h>
#include <stdlib.h>

void move( char x, char y )
{
    printf( "%c -> %c\n", x, y );
}

void hanoi( int n, char x, char y, char z )
{
    if( n == 1 )
    {
        move( x, z );
    }
    else
    {
        hanoi( n - 1, x, z, y );
        move( x, z );
        hanoi( n - 1, y, x, z );
    }
}

int main()
{
    int n;
    printf( "Please input the number of plates: " );
    scanf( "%d", &n );
    printf( "The steps to move %d plates:\n", n );
    hanoi( n, 'A', 'B', 'C' );
    return 0;
}