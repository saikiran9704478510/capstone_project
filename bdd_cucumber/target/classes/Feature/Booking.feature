# Booking.feature
# Scope: Positive, simple BDD scenarios aligned with the provided TestNG flows

@booking @ui @smoke
Feature: Booking.com – Happy path flows
  As a traveler
  I want to search, select, and book a hotel
  So that I can complete a reservation successfully

  # ─────────────────────────────────────────────────────────────────────────────

  @search @filters
  Scenario: Search hyderabad hotels and apply filters with sorting
    Given I open Booking.com
    When I search for destination "hyderabad"
      And I select check-in date "22 September 2025"
      And I select check-out date "23 September 2025"
      And I submit the search
    Then the results page for "hyderabad" is displayed

    When I apply an available filter (e.g. "Free WiFi" or "Star rating")
      And I open sort options
      And I choose "Property rating (low to high)"
    Then the results list is updated accordingly

  # ─────────────────────────────────────────────────────────────────────────────

  @reservation @hotel
  Scenario: Open a specific hotel and choose room quantity
    Given I am on a hotel details page for "Eminent Suites and Apartments" with dates "22 September 2025" to "23 September 2025"
    When I click "Reserve"
      And I select "1" room in the room selection dropdown
    Then the booking step for room selection is updated for 1 room

  # ─────────────────────────────────────────────────────────────────────────────

  @guestdetails @checkout
  Scenario: Enter guest details and proceed with booking
    Given I am on the booking details page for my selected room and dates
    When I enter first name "saikiran"
      And I enter last name "PMV"
      And I enter email "saikiran@gmail.com"
      And I enter phone "9556965987"
      And I continue to the next step
      And I submit the booking
      Then I am taken to the next confirmation or payment step successfully