Feature: Customer Login
	Scenario: Testing Login User
		Given User mengakses url
		When User login dengan username dan password
		And User Menambahkan Product
		And User Membayar Product
		Then User berhasil membeli product