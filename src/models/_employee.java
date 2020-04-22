package models;

/**
 * 従業員クラス
 * @author niche
 *
 */
public class employee {

		/**
		 * 社員No
		 */
		private int  employee_no;

		public int getEmployee_no() {
			return employee_no;
		}

		public void setEmployee_no(int employee_no) {
			this.employee_no = employee_no;
		}

		/**
		 * 氏名
		 */
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		/**
		 * 性別コード
		 */
		private int gender_code;

		public int getGender_code() {
			return gender_code;
		}

		public void setGender_code(int gender_code) {
			this.gender_code = gender_code;
		}

		/**
		 * 社員区分コード
		 */
		private int employee_kubn;

		public int getEmployee_kubn() {
			return employee_kubn;
		}

		public void setEmployee_kubn(int employee_kubn) {
			this.employee_kubn = employee_kubn;
		}


		/**
		 * コンストラクタ
		 * @param employee_no
		 * @param name
		 * @param gender_code
		 * @param employee_kubn
		 */
		public employee(int employee_no, String name, int gender_code,int employee_kubn) {
			super();
			this.employee_no = employee_no;
			this.name = name;
			this.gender_code = gender_code;
			this.employee_kubn = employee_kubn;
		}


}
