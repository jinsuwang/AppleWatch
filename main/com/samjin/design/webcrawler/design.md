https://www.hellointerview.com/learn/system-design/answer-keys/web-crawler

1. Functional Requirement
- crawl the full web starting from seed urls
- extract text data and store

2. Non-Functional Requirement
- Your Crawler can run for only 5 days
- TPS
  - 10B web pages
  - 2Mb per page
  - 5 days to scrape
  - unlimited resources
  - compliance

4. Out of Scope

4. Input/Output (API)
- input: set of seed urls 
- output: text data

5. High level design
- smart scheduler
- URL metadata

6. Scalability and availability improvement