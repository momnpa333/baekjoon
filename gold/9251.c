#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

char string_1[1001];
char string_2[1001];

int score[1001];
int find_ans();
int main()
{
	int current = 0;
	scanf("%s", string_1);

	scanf("%s", string_2);

	for (int i = 0; string_2[i] != '\0'; i++)
	{
		current = 0;
		
		for (int j = 0; string_1[j] != '\0'; j++)
		{
			if (score[j] > current)
			{
				current = score[j];
			}
			else if (string_1[j] == string_2[i])
			{
				score[j] = current+1;
			}
		}
	}

	printf("%d", find_ans());

	return 0;
}
int find_ans()
{
	int max = 0;
	for (int i = 0; i < 1001; i++)
	{
		if (score[i] > max)
		{
			max = score[i];
		}
	}
	return max;
}