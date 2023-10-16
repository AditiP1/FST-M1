from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())
with webdriver.Firefox(service=service) as driver:
    driver.get("https://alchemy.hguy.co/lms")
    driver.find_element(By.ID,"menu-item-1506").click()
    driver.find_element(By.ID,"wpforms-8-field_0").send_keys("Durga Kundu")
    driver.find_element(By.ID,"wpforms-8-field_1").send_keys("DurgaKundu123@gmail.com")
    driver.find_element(By.ID,"wpforms-8-field_3").send_keys("Durga Kundu Test")
    driver.find_element(By.ID,"wpforms-8-field_2").send_keys("Test automation run for activity 8_Python")
    driver.find_element(By.ID,"wpforms-submit-8").click()
    print(driver.find_element(By.ID,"wpforms-confirmation-8").text)
