# snowflake
Generate unique IDs in a Large scale Distributed environment

## How it works?

Let’s say it’s Sun, 23 May 2021 00:00:00 GMT right now. The epoch timestamp for this particular time is **1621728000**

First of all, we adjust our timestamp with respect to the custom epoch-

currentTimestamp = 1621728000- 1621566020 = 161980(Adjust for custom epoch)

So to start our ID, the first 20 bits of the ID (after the signed bit) will be filled with the epoch timestamp.  Let's this value with a left-shift :

```id = currentTimestamp << (NODE_ID_BITS  + SEQUENCE_BITS )```


Next, we take the configured node ID/shard ID and fill the next 10 bits with that 

```id = id | nodeId << SEQUENCE_BITS ```

Finally, we take the next value of our auto-increment sequence and fill out the remaining 6 bits -

```id = id | sequence  // 6149376```

That gives us our final ID 🎉

**Checkout my complete blog post for the same -> https://apoorvtyagi.tech/generating-unique-ids-in-a-large-scale-distributed-environment**
