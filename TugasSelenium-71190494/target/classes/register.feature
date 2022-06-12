Feature: feature to test register functionality
  Scenario Outline: cek register dengan kredensial yang valid
    Given browser dibuka
    And user ada di halaman register
    When user memasukan <firstname> <email> <password>
    And tombol register diklik
#    When email password firstname valid
    Then user diarahkan ke halaman login
    Examples:
      |firstname     |email                | password    |
      |              |                     |             |
      |adrian        |                     | test1234    |
      |adrian        |albertus@gmail.com   |             |
      |              |albertus@gmail.com   | test1234    |
      |adrian        |albertus@gmail.com   | test123     |
      |adrian        |albertus@gmail.com   | test1234567891234 |
      |adrian        |albertus@gmail.com   | test1234**    |
      |adrian        |albertus@gmail.com   | test1234    |




