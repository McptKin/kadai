package kadai1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import models.Employee;

public class main {
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		//CSVファイル読み込み
		String csv ="storage\\employee.csv";
		List<Employee> csvList = readCSV(csv);

		System.out.println("読み込んだCSVを出力します");
		for(Employee emp : csvList){
			System.out.println("社員No:" + emp.getEmployee_no());
			System.out.println("氏名：" + emp.getName());
			System.out.println("性別コード：" + emp.getGender_code());
			System.out.println("社員コード：" + emp.getEmployee_kubn());
			System.out.println("*================================*");
		}

		//読み込んだデータをCSVに書き込み
		writeCSV(csvList);
	}


	/**
	 * CSVファイル読み込み処理
	 * @param path csvが配置されたパス
	 * @return employeeList    従業員リスト
	 */
	private static List<Employee> readCSV(String path){
		File csv = new File(path);																//読み込みCSVファイル
		List<Employee> employees = new ArrayList<Employee>();			//従業員リスト
		int rowCnt = 1;																					//行カウント

		try {
			//ファイル読み込み
			FileReader fr = new FileReader(csv.getAbsolutePath());
			BufferedReader br = new BufferedReader(fr);

			//CSV読み込み
			String line = "";
			while((line = br.readLine() ) != null){
				if(rowCnt != 1){
					//行を配列可
					String[] lines = line.split(",");
					//リストに追加
					employees.add(new Employee(Integer.parseInt(lines[0]), lines[1], Integer.parseInt(lines[2]), Integer.parseInt(lines[3])));
				}
				rowCnt++;
			}

			//読み込み終了
			br.close();

		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return employees;
	}

	/**
	 * CSVに書き込む処理
	 * @param csvList csvファイルに書き込みデータ
	 */
	private static void writeCSV(List<Employee> csvList){

		String wr_csvPath = "storage\\wr_employee.csv";
		File wr_csv = new File(wr_csvPath);
		try {
			//出力ファイルの作成
			FileWriter fw = new FileWriter(wr_csv.getAbsolutePath(),false);
			PrintWriter pw = new PrintWriter(new BufferedWriter(fw));

			//ヘッダー指定
			pw.print("社員No");
			pw.print(",");
			pw.print("氏名");
			pw.print(",");
			pw.print("性別");
			pw.print(",");
			pw.print("社員区分");
			pw.println();

			//明細行書き込み
			for(Employee emp : csvList){
				//1行を一括で書き込む
				String row = appendCSVText(emp);
				pw.print(row);
				pw.println();
			}

			//書き出し終了
			pw.close();

			System.out.println("書き出し終了");

		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	/**
	 *CSVの行データとなる文字列を作成する処理
	 * @param emp 従業員
	 * @return 行
	 */
	private static String appendCSVText(Employee emp){

		StringBuilder sb = new StringBuilder();
		String rowText = "";

		//社員No
		sb.append(emp.getEmployee_no());
		sb.append(",");
		//氏名
		sb.append(emp.getName());
		sb.append(",");
		//性別
		sb.append((emp.getGender_code() == 1 ) ? "男性" :"女性" );
		sb.append(",");
		//社員コード
		if(emp.getEmployee_kubn() == 100){
			sb.append("役員");
		}else if(emp.getEmployee_kubn() == 300){
			sb.append("正社員");
		}else{
			sb.append("アルバイト");
		}

		//一行の文字列に変換
		rowText = sb.toString();
		return rowText;
	}
}
