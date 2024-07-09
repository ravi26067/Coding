### Telus International AI: SDE 3 Interview Process

#### Round 1: Online Test
- **Platform:** HackerRank
- **Format:** 3 Coding questions

#### Round 2: Coding Interview
- **Format:** Face-to-Face
- **Content:** 3 Coding problems

#### Round 3: System Design Interview
- **Scenario:**
  Swiggy is planning to launch a promotional campaign where a limited number of free burgers will be made available to customers. The campaign will be advertised through in-app notifications, and the first users to claim the offer will receive the free burgers. The system should be designed to handle a large volume of requests and ensure that the burgers are distributed fairly among the first users who claim the offer.
  - **Example:** 1000 burgers and 1 million active users.

- **Functional Requirements:**
  1. Send notifications to users.
  2. Users can claim the offer in FIFO order.

- **Non-Functional Requirements:**
  1. Availability
  2. Consistency
  3. Fault tolerance

- **APIs:**
  - `POST /sendNotification`
    ```json
    {
        "city": "Bangalore",
        "type": "App"
    }
    ```
  - Claim Offer
    ```json
    {
        "user_id": "user1",
        "request_time": 123401234,
        "offer_id": "offer1",
        "product_id": "product1"
    }
    ```

- **Estimations:**
  - **Load:** 1M requests per minute
  - **Request Size:** 100 bytes
  - **RPS:** 
    ```plaintext
    10^6 / 60 = 1.7 x 10^4 = 17,000
    ```
  - **Bandwidth Required:**
    ```plaintext
    1.7 x 10^6 Bytes = 1.7 MB/s
    ```
  - **Total Data for 3 Minutes:**
    ```plaintext
    1.7 x 60 x 3 min = 306 MB
    ```

- **Details:**
  - Assuming the Offers Service will receive an equal amount of load, the requests can be processed in batches at the Offers Service itself.
  - Only 1000 requests from each node in the Offers Service will be sent to Kafka for further processing.
  - The first 1000 requests will be selected in the Offer Processor and sent to the Inventory Service where the orders will be placed.

#### Round 4: Hiring Manager Interview
- **Details:**
  - Discussion on the feature worked on along with a High-Level Design (HLD).
