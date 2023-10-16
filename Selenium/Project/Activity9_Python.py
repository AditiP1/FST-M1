from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())
with (webdriver.Firefox(service=service) as driver):
    driver.get("https://alchemy.hguy.co/lms")
    driver.find_element(By.ID, "menu-item-1507").click()
    driver.find_element(By.CLASS_NAME, "ld-login-text").click()
    driver.find_element(By.ID, "user_login").send_keys("root")
    driver.find_element(By.ID, "user_pass").send_keys("pa$$w0rd")
    driver.find_element(By.ID, "wp-submit").click()
    driver.find_element(By.ID, "menu-item-1508").click()
    driver.find_element(By.CLASS_NAME, "ld_course_grid_button").click()
    driver.find_element(By.XPATH, "//div[3]/div[2]/div[1]/div[1]/a/div[2]").click()
    course = driver.title
    assert course == "Developing Strategy – Alchemy LMS"
    status = driver.find_element(By.XPATH, "//div[2]/div[2]/div/div/div[1]/div/div[2]")
    print("Here is the value ")
    print(status.text)
    assert status.text == "COMPLETE"
