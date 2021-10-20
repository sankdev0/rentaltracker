package com.sankdev.rentaltracker;

public final class Organization {

  private final String name = "ООО \"Аренда Мир \"";

  private final String address = "460000, Россия, г. Оренбург, ул. Мира, д. 3471";

  private final String phone = "+7 (3532) 71-88-99";

  private final String email = "info@arenda.ru";

  public Organization() {

  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  public String getPhone() {
    return phone;
  }

  public String getEmail() {
    return email;
  }
}
