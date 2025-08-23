#include <algorithm>
#include <iostream>
#include <string>
#include <vector>


using namespace std;
typedef vector<vector<int>> matrix_t; 
void tromino(int N, int row, int col, int hole_row, int hole_col);
void fillCornersExcept(int midRow, int midCol, int flag);
int cnt;
matrix_t answer;
int main()
{
	int N;
	int hole_row, hole_col;
	cin >> N>>hole_row>>hole_col;
	int size = 1;
	/*int x, y;
	cin >> n >> x >> y;*/
	for (int i = 0; i < N; i++) {
		size *= 2;
	}

	answer.resize(size,vector<int>(size));
	answer[size-hole_col][hole_row-1] =-1;

	tromino(size, 0, 0,size-hole_col,hole_row-1);

	for (int i = 0; i < size; i++)
	{
		for (int j = 0; j < size; j++)
		{
			if (j != size-1)
				cout << answer[i][j] << " ";
			else
				cout << answer[i][j];
		}
		cout << "\n";
	}
	return 0;
}
void tromino( int N, int row, int col,int hole_row,int hole_col)
{
	if (N == 1)
		return;

	int midrow=row+N/2;
	
	int midcol=col+N/2;

	if (hole_row >= midrow && hole_col >= midcol)
	{
		fillCornersExcept(midrow, midcol, 4);
		tromino( N / 2, row, col, midrow-1,midcol-1);
		tromino( N / 2, row, midcol, midrow - 1, midcol);
		tromino( N / 2, midrow, col, midrow, midcol - 1);
		tromino( N / 2, midrow, midcol, hole_row, hole_col);
	}
	else if (hole_row >= midrow && hole_col < midcol)
	{
		fillCornersExcept(midrow, midcol, 3);
		tromino( N / 2, row, col, midrow-1,midcol-1);
		tromino( N / 2, row, midcol, midrow - 1, midcol);
		tromino( N / 2, midrow, col, hole_row, hole_col);
		tromino( N / 2, midrow, midcol, midrow, midcol);
	}
	else if (hole_row < midrow && hole_col >= midcol)
	{
		fillCornersExcept(midrow, midcol, 2);
		tromino( N / 2, row, col, midrow-1,midcol-1);
		tromino( N / 2, row, midcol, hole_row, hole_col);
		tromino( N / 2, midrow, col, midrow, midcol - 1);
		tromino( N / 2, midrow, midcol, midrow, midcol);
	}
	else
	{
		fillCornersExcept(midrow, midcol, 1);
		tromino( N / 2, row, col, hole_row, hole_col);
		tromino( N / 2, row, midcol, midrow - 1, midcol);
		tromino( N / 2, midrow, col, midrow, midcol - 1);
		tromino( N / 2, midrow, midcol, midrow, midcol);
	}

}
void fillCornersExcept(int midRow, int midCol, int flag)
{
	cnt++;
	if (flag != 1)
		answer[midRow - 1][midCol - 1] = cnt;
	if (flag != 2)
		answer[midRow - 1][midCol] = cnt;
	if (flag != 3)
		answer[midRow][midCol - 1] = cnt;
	if (flag != 4)
		answer[midRow][midCol] = cnt;

	return;
}