package fpt.poly.testing;

import java.util.Scanner;

public class HinhChuNhat {
	protected double chieuDai, chieuRong, chuVi, dienTich;
	Scanner scanner = new Scanner(System.in);

	public void nhap() {
		do {
			System.out.println("Nhập chiều dài hình chữ nhật: ");
			chieuDai = scanner.nextDouble();
			System.out.println("Nhập chiều rộng hình chữ nhật: ");
			chieuRong = scanner.nextDouble();
		} while (chieuDai < chieuRong);
	}

	public void hienThi(double dai, double rong) {
		System.out.println("Chiều dài và chiều rộng của hình chữ nhật lần lượt là " + chieuDai + " và " + chieuRong);
	}

	public double tinhChuVi(double dai, double rong) {
		chuVi = (dai + rong) * 2;
		return chuVi;
	}

	public double tinhDienTich(double dai, double rong) {
		dienTich = dai * rong;
		return dienTich;
	}

	public void hienThiChuViVaDienTich(double cv, double dt) {
		System.out.println("Chu vi hình chữ nhật = " + cv);
		System.out.println("Diện tích hình chữ nhật = " + dt);
	}

	public static void main(String[] args) {
		HinhChuNhat hinhChuNhat = new HinhChuNhat();

		// nhập chiều dài và chiều rộng hình chữ nhật
		hinhChuNhat.nhap();

		// hiển thị chiều dài và chiều rộng
		hinhChuNhat.hienThi(hinhChuNhat.chieuDai, hinhChuNhat.chieuRong);

		// tính chu vi và diện tích
		double chuVi = hinhChuNhat.tinhChuVi(hinhChuNhat.chieuDai, hinhChuNhat.chieuRong);
		double dienTich = hinhChuNhat.tinhDienTich(hinhChuNhat.chieuDai, hinhChuNhat.chieuRong);

		// hiển thị chu vi và diện tích
		hinhChuNhat.hienThiChuViVaDienTich(chuVi, dienTich);
	}

}
