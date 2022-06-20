Feature: Testing Payment
	Scenario: Testing Membayar Product dengan valid
		When User proceed product
		And User proceed address
		And User proceed shipping
		And User payment product
		Then User berhasil membayar product