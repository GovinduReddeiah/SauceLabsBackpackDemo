1. Why did you choose this framework structure? 
chose a BDD structure so non‑technical stakeholders can understand and even run test cases. By following AVN and POM, actions, locators, and methods are separated into clear folders, making changes easy to track and maintain

2. How does your wait strategy prevent flakiness? 

I didn't used any waits here, but if needed i would prefer mostly explicit waits, which synchronize tests with the application state. This prevents flakiness by waiting only until elements are interactable, avoiding unnecessary delays or race conditions.

3. How does your locator strategy improve stability? 

I prioritize stable, unique locators like IDs or data-test attributes. If those aren’t available, I use semantic attributes or parent‑child traversal. I avoid fragile strategies like indexes, which break easily when the UI changes

4. How would you scale this to 50+ scenarios? 

As i have utility folders, i can reuse Data related utilities and in step def as well i can re use same page classes when ever required so that i can build as many as cases which are interrelated by reusing this same code.

5. How would you execute this in CI/CD? 

i will integrate with Jenkins/GitHub Actions.
Jenkins - will create pipeline jobs, those jobs will trigger automatically when ever we got build related builds            from Dev team.
GitHubAction - by creating yaml file will monitor Dev builds which are related to this code 
by these results i will confirm those builds are stable or not and will use Allure reports for easy monitoring test case status

6. Two improvements you would make with more time. 
reports, browser setup