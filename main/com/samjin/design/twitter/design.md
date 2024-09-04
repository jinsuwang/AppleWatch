1. Functional Requirement
-   Users should be able to create posts.
-   Users should be able to friend/follow people.
-   Users should be able to view a feed of posts from people they follow, in chronological order.
-   Users should be able to page through their feed.

2. Non-Functional Requirement
-   The system should be highly available (prioritizing availability over consistency). Tolerate up to 2 minutes for eventual consistency.
-   Posting and viewing the feed should be fast, returning in < 500ms.
-   The system should be able to handle a massive number of users (2B).
-   Users should be able to follow an unlimited number of users, users should be able to be followed by an unlimited number of users.
3. Out of Scope
-   Users should be able to like and comment on posts.
-   Posts can be private or have restricted visibility.

4. Input/Output (API)

5. high level design
6. Scalability and availability improvement
- Change Data Capture(CDC)
- Fanout on write
- Fanout on read