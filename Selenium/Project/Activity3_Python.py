from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager


service = FirefoxService(GeckoDriverManager().install())
with webdriver.Firefox(service=service) as driver:
    driver.get("https://alchemy.hguy.co/lms")
    text1= driver.find_element(By.XPATH,"//div[1]/div[2]/div/div/div/div/div[2]/h3").text
    print(text1)
    assert text1 == "Actionable Training"
