import java.io.FileWriter;
import java.io.IOException;

public class Car {

	int id, YearofManufacture;
	String Make, Model, Color, RegistrationNumber;
	double Price;
	
	public Car(int id, String Make, String Model, int YearofManufacture, String Color, double Price,
			String RegistrationNumber) {

		this.id = id;
		this.Make = Make;
		this.Model = Model;
		this.YearofManufacture = YearofManufacture;
		this.Color = Color;
		this.Price = Price;
		this.RegistrationNumber = RegistrationNumber;
	}

	public String getCarInfo() {
		return "Car [id=" + id + ", Make=" + Make + ", Model=" + Model + ", YearofManufacture=" + YearofManufacture
				+ ", Color=" + Color + ", Price=" + Price + ", RegistrationNumber=" + RegistrationNumber + "]";
	}

	public class carlist {

		public static void ByBrand(Car[] cars, String GivenBrand, String FileName) throws IOException {

			FileWriter writer = new FileWriter(FileName);

			for (int i = 0; i < cars.length; i++) {
				if (cars[i].Make.equals(GivenBrand)) {
					String carInfo = cars[i].getCarInfo();
					writer.write("a list of cars of a given brand saved in file; " + "\n" + carInfo + "\n"); // Save to
																												// the
																												// file
					System.out.println("a list of cars of a given brand; " + "\n" + carInfo);
				}
			}
			writer.close();

		}

		public static void ByModelAndYear(Car[] cars, String GivenModel, int SpecifiedYears, String FileName)
				throws IOException {

			FileWriter writer = new FileWriter(FileName);

			int RecentYear = 2023;
			for (int i = 0; i < cars.length; i++) {
				if (cars[i].Model.equals(GivenModel) && (RecentYear - cars[i].YearofManufacture) > SpecifiedYears) {
					String carInfo = cars[i].getCarInfo();
					writer.write(
							"a list of cars of a given model that have been in use for more than n years saved in file; "
									+ "\n" + carInfo + "\n"); // Save to the file
					System.out.println("a list of cars of a given model that have been in use for more than n years; "
							+ "\n" + carInfo);
				}
			}

			writer.close();
		}

		public static void ByYearAndPrice(Car[] cars, int GivenYear, double SpecifiedPrice, String FileName)
				throws IOException {

			FileWriter writer = new FileWriter(FileName);

			for (int i = 0; i < cars.length; i++) {
				if (cars[i].YearofManufacture == GivenYear && cars[i].Price > SpecifiedPrice) {
					String carInfo = cars[i].getCarInfo();
					writer.write(
							"a list of cars of a given year of manufacture, the price of which is higher than the specified by one saved in file;"
									+ "\n" + carInfo + "\n"); // Save to the file
					System.out.println(
							"a list of cars of a given year of manufacture, the price of which is higher than the specified by one"
									+ "\n" + carInfo);
				}
			}
			writer.close();
		}

		public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub

			Car[] cars = { new Car(1, "Hundai", "Mira", 2000, "Red", 25000.0, "abc1"),
					new Car(2, "Suzuki", "Cultus", 2021, "Blue", 22000.0, "abc2"),
					new Car(3, "MG", "Civic", 2007, "Golden", 28000.0, "abc3"),
					new Car(4, "Toyota", "Mehran", 2020, "Black", 25000.0, "abc4"), };

			ByBrand(cars, "Hundai", "BrandFile.txt");
			ByModelAndYear(cars, "Civic", 5, "UseFile.txt");
			ByYearAndPrice(cars, 2020, 24000.0, "Pricefile.txt");

		}
	}
}
