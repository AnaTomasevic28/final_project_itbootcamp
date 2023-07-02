public class DragoljubTestDodavanjeKorisnika {
//    @Test
//    public void userCanAddData() {
//        goToElements();
//        sidebar.clickOnWebTables();
//
//        deleteAllEntries(); //Posebna metoda koja brise sve postojece podatke (cleanup)
//
//        int j = 0;
//        for (int i = 1; i <= excelReader.getLastRowNumber(); i++) {
//
//            String firstName = excelReader.getStringData("Users", i, 0);
//            String lastName = excelReader.getStringData("Users", i, 1);
//            String email = excelReader.getStringData("Users", i, 2);
//            int age = excelReader.getIntegerData("Users", i, 3);
//            int salary = excelReader.getIntegerData("Users", i, 4);
//            String department = excelReader.getStringData("Users", i, 5);
//
//            wait(webTablesPage.AddButton); //Cekanje da dugme Add bude klikabilno, metoda je napravljena u klasi za page
//
//            webTablesPage.clickOnAdd();
//            webTablesPage.inputFirstName(firstName);
//            webTablesPage.inputLastName(lastName);
//            webTablesPage.inputEmail(email);
//            webTablesPage.inputAge(age);
//            webTablesPage.inputSalary(salary);
//            webTablesPage.inputDepartment(department);
//            webTablesPage.clickOnSubmit();
//
//            //Proveru bih ostavio u ovoj metodi uz petlju, a napravio bih prethodno posebno metodu samo za dodavanje podataka
//            //Proveravam da li je svaki pojedinaca unos prikazan na FE
//            Assert.assertEquals(firstName, webTablesPage.cellText(j));
//            Assert.assertEquals(lastName, webTablesPage.cellText(j+1));
//            Assert.assertEquals(String.valueOf(age), webTablesPage.cellText(j+2));
//            Assert.assertEquals(email, webTablesPage.cellText(j+3));
//            Assert.assertEquals(String.valueOf(salary), webTablesPage.cellText(j+4));
//            Assert.assertEquals(department, webTablesPage.cellText(j+5));
//
//            j = j + 7;
//        }
//        //deleteAllEntries();
//        //cleanup se moze dodati i na kraju, ali s obzirom da program ne pamti unose onda nema potrebe
//    }
}
