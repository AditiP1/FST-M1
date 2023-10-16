from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager


service = FirefoxService(GeckoDriverManager().install())
with webdriver.Firefox(service=service) as driver:
    driver.get("https://alchemy.hguy.co/lms")
    MostPopular2 = driver.find_element(By.XPATH, "//div[2]/article/div[2]/h3").text
    assert MostPopular2 == "Email Marketing Strategies"
