import { styled } from 'goober';

export const ContentBackground = styled('div')`
  background-image: linear-gradient(180deg, transparent, #282828 80%), url(/hsr-background.png);
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
  z-index: -1;
  position: absolute;
  top: 0;
  width: 100%;
  height: 1000px;
`;
