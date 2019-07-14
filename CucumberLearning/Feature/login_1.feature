Feature: Test for Interview

## Author- Gyanadeep Sahoo
## URL - https://en.wikipedia.org/wiki/Metis_(mythology)

## Test Case:
# a) the headings listed in the `Contents` box are used as headings on the page
# b) the headings listed in the `Contents` box have functioning hyperlinks
# c) in the _Personified concepts_, `Nike` has a popup that contains the following text:
#    In ancient Greek religion, Nike was a goddess who personified victory. Her Roman equivalent was Victoria.
# d) in the _Personified concepts_, if you click on `Nike`, it takes you to a page that displays a family tree


    Scenario: Navigate to wikipedia mythology page and verify links
        ## Navigate to wiki page
        Given User Navigates to "https://en.wikipedia.org/wiki/Metis_(mythology)" in browser
        ## Verify link Family and Click Family link
        Then I should see element with xpath "//a[@href]//span[text()='Family']"
        When I click on "//a[@href]//span[text()='Family']"
        ## Verify link Mythology and click the link
        Then I should see element with xpath "//a[@href]//span[text()='Mythology']"
        When I click on "//a[@href]//span[text()='Mythology']"
        ## Verify link References and click the link
        Then I should see element with xpath "//a[@href]//span[text()='References']"
        When I click on "//a[@href]//span[text()='References']"
        ## Verify link Future Reading and click the link
        Then I should see element with xpath "//a[@href]//span[text()='Further reading']"
        When I click on "//a[@href]//span[text()='Further reading']"

        ## Verify Nike link and do mouse over
        Then I should see element with xpath "//a[@href][text()='Nike']"
        When I do mouseover on xpath "//a[@href][text()='Nike']"
        ## Then verify text on mHover on Nike
        ##Then User should see Text "In ancient Greek religion"

        ##Click on Nike link
        When I click on "//a[@href][text()='Nike']"
        ##Verify Faily tree should be displayed
        Then I should see element with xpath "//table[@class='toccolours']//tbody"
        Then Close the browser
