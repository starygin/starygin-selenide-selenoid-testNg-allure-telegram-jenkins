# starygin-selenide-selenoid-testNg-allure-telegram-jenkins
# step_1. Install selenoid.
# step_2. Install Jenkins. Create Job (pipeline). Copy JenkinsFile in pipeline. Сhange the credentials in stage('git'). Сhange the token_bot, id_chat and jenkins(link) in  stage('telegram')
# step_3. Run job
# If you need change count retry, you need add JenkinsFile add env.RETRY = "99"
# If you need change browser/version/vnc/video you need change configure.properties
# If you need change link in issue you need change allure.properties 
