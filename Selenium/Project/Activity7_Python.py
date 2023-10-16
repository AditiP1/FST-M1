from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())
with webdriver.Firefox(service=service) as driver:
    driver.get("https://alchemy.hguy.co/lms")
    driver.find_element(By.ID, "menu-item-1508").click()
    elementlist=driver.find_elements(By.XPATH,"//article/div[2]/h3")
    for cell in elementlist:
        print(cell.text)