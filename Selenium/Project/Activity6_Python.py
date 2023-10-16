from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())
with webdriver.Firefox(service=service) as driver:
    driver.get("https://alchemy.hguy.co/lms")
    driver.find_element(By.ID, "menu-item-1507").click()
    AccTitle = driver.title
    print(AccTitle)
    assert AccTitle == "My Account – Alchemy LMS"
    driver.find_element(By.CLASS_NAME, "ld-login-text").click()
    driver.find_element(By.ID, "user_login").send_keys("root")
    driver.find_element(By.ID, "user_pass").send_keys("pa$$w0rd")
    driver.find_element(By.ID, "wp-submit").click()
    assert "root" == driver.find_element(By.XPATH, "/html/body/div[2]/div/ul[2]/li[2]/a/span").text
