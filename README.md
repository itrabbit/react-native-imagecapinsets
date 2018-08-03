# React Native ImageCapInset
Support Image capInsets for Android (only for RN >= 0.56)

## Installation

1. `yarn add react-native-imagecapinsets`
2. `react-native link react-native-imagecapinsets`

## Example

```javascript
import ImageCapInset from 'react-native-imagecapinsets';

import BubbleImage from './images/bubble.png';

<ImageCapInset source={BubbleImage}
               capInsets={{ top: 8, right: 8, bottom: 8, left: 8 }} />
```

## Credits

Continued development under RN 0.56
[react-native-image-capinsets](https://github.com/madsleejensen/react-native-image-capinsets)
package.
