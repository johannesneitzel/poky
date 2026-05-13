#include <stdio.h>

int add(int a, int b);

int main(void)
{
    printf("Hello, World!\n");
    printf("2 + 3 = %d\n", add(2, 3));
    return 0;
}

int add(int a, int b)
{
    return a + b;
}