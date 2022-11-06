#include <iostream>
#include <vector>
#include <algorithm>
#include <limits.h>

int N, A, B;
std::vector<std::pair<int, int>> datas;

void input()
{
	std::cin >> N;
	datas.reserve(N);
	std::cin >> A >> B;
	for (int n = 1; n < N; n++)
	{
		int a, b;
		std::cin >> a >> b;
		datas.push_back(std::make_pair( a, b ));
	}
}
unsigned dp[505][3]{ 0 };
void solve()
{
	dp[0][0] = A * B * datas[0].second;
	dp[0][1] = A * B * datas[0].second;
	dp[0][2] = A * B * datas[0].second;

	for (int n = 1; n <= N - 2; n++)
	{
		dp[n][0] = dp[n - 1][2] + A * datas[n].first * datas[n].second;
		unsigned min = UINT32_MAX;
		unsigned sum = 0;
		for (int j = n; j > 0; j--)
		{
			sum += datas[j - 1].first * datas[j - 1].second * datas[n].second;
			int tmp = sum + dp[j - 1][2];
			min = (tmp < min) ? min : tmp;
		}
		sum += A * B * datas[n].second;
		min = (sum < min) ? min : sum;

		dp[n][1] = min;
		dp[n][2] = std::min(dp[n][0], dp[n][1]);
	}

	std::cout << dp[N - 2][2];
}

int main()
{
	input();
	return 0;
}
