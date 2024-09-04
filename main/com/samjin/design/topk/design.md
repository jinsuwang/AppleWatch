https://www.hellointerview.com/learn/system-design/answer-keys/top-k


1. Functional Requirement
- Query top-k most viewed videos (1000 video max)
- accept a parameter which is time period(minute, hour, day, all-time)
- sliding window
- no arbitrary starting point

2. Non-Functional Requirement
- TPS (massive views, massive videos)
- SLA ( < 1min)
- Latency (10ms-100ms in read)
- no approximations
- 
3. Out of Scope
4. Input/Output (API)
Input: K
Output: [{videoId, views}]

5. high level design
6. Scalability and availability improvement