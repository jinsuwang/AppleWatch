

Link: https://www.hellointerview.com/learn/system-design/answer-keys/ticketmaster


1. Functional Requirement
2. Non-Functional Requirement 
- TPS 
- storage requirement
- Read / Write
3. Out of Scope
4. APIs
5. high level design 
6. Scalability


Notes:
2 stages booking
- reserve
- confirm 

high consistency on booking
high availability on searching and viewing

Database offer change event stream to Search index

Search cache for hot keywords

for super hot event, we add virtual waiting queue.