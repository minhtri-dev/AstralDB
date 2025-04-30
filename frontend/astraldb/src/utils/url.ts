export function getQueryParam(url: string, param: string | null = null): URLSearchParams | string | null {
  const urlObj = new URL(url)
  const params = new URLSearchParams(urlObj.search)

  if (param === null) {
    return params
  } else {
    return params.get(param)
  }
}
