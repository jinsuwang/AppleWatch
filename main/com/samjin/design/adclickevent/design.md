
article: https://medium.com/@nvedansh/system-design-ad-click-event-aggregation-8fb6aa7817fc

Requirement - use case
1. Return the number of click events in the last M minutes for a particular advertisement.
2. Return the top N ads clicked in the last M minutes.

Requirement - scalability
1. 1 billion DAU(Daily Active Users)
2. 1 billion ad clicks per day, assuming each user clicks one ad daily.
3. Ad-Clicks QPS = 10⁹ events / 10⁵ seconds = 10,000 QPS
4. Assuming Peak QPS is 5 times of average QPS, Peak QPS is 50k QPS
5. Assuming a single ad click event has 0.1KB storage, the daily storage requirement would be 0.1KB * 10⁹ = 100 GB, monthly we would require 3TB of memory.


Service - Design

Query API Design

API-1: Aggregate the number of clicks of ad-id in the last M minutes
GET API: /v1/ads/{:ad_id}/aggregated_count

Query Params:
1. Start_Time: Default value can be current_time minus 1 minute
2. To_Time: Default value can be current_time
3. Filter_Identifier: This is an optional field, we can have a dedicated set of identifiers for e.g if filter=001 that means we can filter according to IP address.

Response: Return aggregated event count for a given ad_id
ad_id: The ad identifier
count: Number of times the particular ad was clicked.

API-2: Return Top N clicked Ad-Ids in the last M minutes.
GET API: /v1/ads/top_clicked_ads

Query Params:
1. Start_Time: Default value can be current_time minus 1 minute
2. To_Time: Default value can be current_time
3. N: Number of Top Ads to return, default value can be 10
4. Filter_Identifier: This is an optional field, we can have a dedicated set of identifiers for e.g if filter=001 that means we can filter according to IP address.

Response: Return aggregated event count for a given ad-id
ad_ids: List of the ad identifiers


Storage
For Raw Data, as discussed in previous sections we have nearly 50K peak QPS which means our system is write-heavy. Also, we have a lot of analytical queries that will be the logic of our APIs. Our data is also continuously growing so we need a scalable distributed database.

Why 2 database
* resources contention
* fault isolation