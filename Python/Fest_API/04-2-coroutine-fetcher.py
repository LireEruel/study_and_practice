
import aiohttp
import time
import asyncio


async def fetcher(session, url):
    async with session.get(url) as response:
        return await response.text()


async def main():
    urls = ["http://naver.com", "https://google.com", "https://instagram.com"]

    async with aiohttp.ClientSession() as session:
        result = await asyncio.gather(*[fetcher(session, url) for url in urls])
        print(result)

if __name__ == "__main__":
    asyncio.run(main())
