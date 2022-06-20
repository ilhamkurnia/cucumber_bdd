Feature: Testing Add Cart
	Scenario: Testing Menambahkan Product dengan valid
		When User menambahkan product women
		And User menambahkan product dress
		And User menambahkan product shirt
		Then User berhasil menambahkan ketiga product