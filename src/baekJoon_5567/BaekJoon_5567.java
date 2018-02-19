package baekJoon_5567;

import java.util.Scanner;

public class BaekJoon_5567 {
	static friends[] friendList;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n,m;
		n = scan.nextInt();
		m = scan.nextInt();

		friendList = new friends[n + 1];
		for (int i = 1; i < n + 1; i++) {
			friendList[i] = new friends(n + 1);
		}

		for (int i = 0; i < m; i++) {
			int ai = scan.nextInt();
			int bi = scan.nextInt();
			friendList[ai].addFriend(bi);
		}

		int[] result = new int[n + 1];
		for (int i = 0; i < n + 1; i++) {
			result[i] = 0;
		}

		for (int i = 1; i <= n; i++) {
			if (friendList[1].isExist(i)) {
				result[i] = 1;
				for (int j = 1; j <= n; j++) {
					if (friendList[i].isExist(j) && result[j] != 1) {
						result[j] = 1;
					}
				}
			}
		}
		int count = 0;
		for (int i : result) {
			if (i == 1) {
				count++;
			}
		}
		System.out.println(count);
		scan.close();
	}
}

class friends {
	private int[] onesFriends;

	public friends(int n) {
		onesFriends = new int [n];
		for (int i = 1; i < n; i++) {
			this.onesFriends[i] = 0;
		}
	}

	public boolean isExist(int i) {
		return onesFriends[i] == 1;
	}

	public void addFriend(int i) {
		onesFriends[i] = 1;
	}
}